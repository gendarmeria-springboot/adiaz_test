import { Component, OnInit } from '@angular/core';
import { PenadoService } from 'src/app/services/penado.service';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';


@Component({
  selector: 'app-penado',
  templateUrl: './penado.component.html',
  styleUrls: ['./penado.component.css']
})
export class PenadoComponent implements OnInit {
  showPenadoButton: boolean;
  constructor(private penadoService:PenadoService) { }
  currenpenado: any;
  items: any[];

  ngOnInit() {
    this.showPenadoButton = true;
    this.currenpenado = {};
    this.currenpenado.id = '',
    this.currenpenado.run = '';
    this.currenpenado.apellidos = '';
    this.currenpenado.nombres = '';
    this.currenpenado.direccion = "";
  }
  crear() {
    const validResult = this.penadoService.isValid(this.currenpenado);
    if (!validResult.ok) {
      console.error(`Hey, there is an error: ${validResult.message}`);
      return;
    }
    this.penadoService.crear(this.currenpenado)
    .pipe(
      catchError(err => {
        console.error(`este error se ejecuta antes del res del subscribe: ${err}`);
        return of([]);
      })
    )
    //el spinner
    .subscribe(
      res => {
        console.log(res);
        this.currenpenado();
      },
      err => {
        console.error(`este error se ejecuta cuando http falla: ${err}`);
      });
    }
    buscar(){
      this.penadoService.buscar(this.currenpenado)
      .pipe(
        catchError(err => {
          console.error(`este error se ejecuta antes del res del subscribe: ${err}`);
          return of([]);
        })
      )
      .subscribe(
        res => {
          console.log(res);
          this.currenpenado();
        },
        err => {
          console.error(`este error se ejecuta cuando http falla: ${err}`);
        })
    }
    actualizar(){
      this.penadoService.actualizar(this.currenpenado)
      .pipe(
        catchError(err => {
          console.error(`este error se ejecuta antes del res del subscribe: ${err}`);
          return of([]);
        })
      )
      .subscribe(
        res => {
          console.log(res);
          this.currenpenado();
        },
        err => {
          console.error(`este error se ejecuta cuando http falla: ${err}`);
        })
    }
      toggle() {
        this.showPenadoButton = !this.showPenadoButton;
      }
      showItems() {
        this.items = this.penadoService.getItems();
        console.log(this.items);
      }
}