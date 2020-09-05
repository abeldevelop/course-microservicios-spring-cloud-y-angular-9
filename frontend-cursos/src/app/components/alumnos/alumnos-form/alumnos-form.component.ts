import { Component, OnInit } from '@angular/core';
import { Alumno } from 'src/app/models/alumno';
import { AlumnoService } from 'src/app/services/alumno.service';
import { Router, ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-alumnos-form',
  templateUrl: './alumnos-form.component.html',
  styleUrls: ['./alumnos-form.component.css']
})
export class AlumnosFormComponent implements OnInit {

  titulo = 'Crear Alumno';
  alumno: Alumno = new Alumno();

  error: any;

  constructor(
    private alumnoService: AlumnoService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(
      params => {
        const id: number = +params.get('id');
        if (id) {
          this.titulo = 'Editar Alumno';
          this.alumnoService.ver(id)
            .subscribe(alumno => this.alumno = alumno);
        }
      }
    );
  }

  crear(): void {
    this.alumnoService.crear(this.alumno)
      .subscribe(
        alumno => {
          console.log(alumno);
          Swal.fire('Nuevo:', `Alumno ${alumno.nombre} creado con exito`, 'success');
          this.router.navigate(['/alumnos']);
        },
        error => {
          if (error.status === 400) {
            this.error = error.error;
            console.log(error);
          }
        });
  }

  editar(): void {
     this.alumnoService.editar(this.alumno)
      .subscribe(
        alumno => {
          console.log(alumno);
          Swal.fire('Modificado:', `Alumno ${alumno.nombre} actualizado con exito`, 'success');
          this.router.navigate(['/alumnos']);
        },
        error => {
          if (error.status === 400) {
            this.error = error.error;
            console.log(error);
          }
        });
  }
}
