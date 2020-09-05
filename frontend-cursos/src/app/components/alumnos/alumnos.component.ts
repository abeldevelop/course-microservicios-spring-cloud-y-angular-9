import { Component, OnInit } from '@angular/core';
import { AlumnoService } from 'src/app/services/alumno.service';
import { Alumno } from 'src/app/models/alumno';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-alumnos',
  templateUrl: './alumnos.component.html',
  styleUrls: ['./alumnos.component.css']
})
export class AlumnosComponent implements OnInit {

  titulo = 'Listado de Alumnos';
  alumnos: Alumno[] = [];

  constructor(private alumnoService: AlumnoService) { }

  ngOnInit(): void {
    this.alumnoService.listar()
      .subscribe(
        alumnos => {
          this.alumnos = alumnos;
        });
  }

  eliminar(alumno: Alumno): void {
    Swal.fire({
      title: 'Cuidado',
      text: `¿Seguro que desea eliminar a ${alumno.nombre}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!'
    }).then((result) => {
      if (result.value) {
        this.alumnoService.eliminar(alumno.id).subscribe(() => {
          this.alumnos = this.alumnos.filter(a => a !== alumno);
          Swal.fire('Eliminado', `Alumno ${alumno.nombre} eliminado con exito`, 'success');
        });
      }
    })
  }
}
