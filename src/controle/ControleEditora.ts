import { Editora } from './../modelo/Editora';

export class ControleEditora {
  editoras: Editora[];

  constructor() {
    this.editoras = [
      new Editora(1, 'Editora A'),
      new Editora(2, 'Editora B'),
      new Editora(3, 'Editora C'),
    ];
  }

  getEditoras(): Editora[] {
    return this.editoras;
  }

  getNomeEditora(codEditora: number): string {
    const editora = this.editoras.find((e) => e.codEditora === codEditora);
    return editora ? editora.nome : '';
  }
}
