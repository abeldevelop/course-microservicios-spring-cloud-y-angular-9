export class Asignatura {
    id: number;
    padre: Asignatura;
    hijos: Asignatura[] = [];
}
