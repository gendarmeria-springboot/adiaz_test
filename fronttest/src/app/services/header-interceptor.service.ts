import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class HeaderInterceptorService implements HttpInterceptor {

  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const request = req.clone({
      setHeaders: {
        // 'Authorization': `Bearer ${this.dataService.getToken()}`,
        'Content-Type': 'application/json'
      }
    });
    return next.handle(request);
  }
}