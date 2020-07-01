import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';
import { STRING_TYPE } from '@angular/compiler/src/output/output_ast';
import { HttpParams } from '@angular/common/http';


const routes = {
  crear: '/penado/crear',
  buscar: '/penado/buscar',
  actualizar:'penado/actualizar',
  eliminar: 'penado/eliminar'
  };


@Injectable({
  providedIn: 'root'
})
export class PenadoService {
  constructor(private apiService: ApiService) { }
  
  isValid(penado: any): any {
    const response = { ok: false, message: '' };
   }

  // if (penado === undefined || penado === null) {
  //     response.ok = false;
  //     response.message = 'object is null.';
  //     return response;
  //   }

  // if (penado.run === undefined || penado.run === null || penado.run.trim() === '') {
  //   return { ok: false, message: 'Run is null.' };
  // }

  // if (penado.nombres === undefined || penado.nombre === null || inmate.nombre.trim() === '') {
  //   return { ok: false, message: 'nombre is null.' };
  // }
  // return { ok: true, message: 'datos ingresados is a valid object.' };

  getItems(): any[] {
    return [{ id: 1, name: 'my name is 1' },
    { id: 2, name: 'my name is 2' },
    { id: 3, name: 'my name is 3' }];
  }

  crear(penado: any) {
    //debugger;
    const postPenado = {
      id: penado.id,
      run:penado.run,
      nombres:penado.nombres,
      apellidos:penado.apellidos,
      direccion:penado.dieccion
      } ;
    return this.apiService.post(routes.crear, postPenado)
    ;
    }
    buscar(penado: any){
      const getPenado = {
        id: penado.id,
        run:penado.run,
        nombres:penado.nombres,
        apellidos:penado.apellidos,
        direccion:penado.dieccion
      } ;
      return this.apiService.post(routes.buscar, getPenado)
      ;
    }
    actualizar(penado: any){
      const putPenado ={
        id: penado.id,
        run:penado.run,
        nombres:penado.nombres,
        apellidos:penado.apellidos,
        direccion:penado.dieccion
      };
      return this.apiService.put(routes.actualizar,putPenado);
    }
    // eliminar(penado:any){
    //     const deletePenado = id.penado;
    //     // {
    //     //    id: penado.id,
    //     //   run:penado.run,
    //     //   nombres:penado.nombres,
    //     //   apellidos:penado.apellidos,
    //     //   direccion:penado.dieccion
    //     // };
    //     return this.apiService.delete(routes.eliminar,deletePenado);
    // }

    
    


}

