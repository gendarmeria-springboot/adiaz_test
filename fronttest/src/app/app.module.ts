import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { PenadoComponent } from './components/penado/penado.component';
import { HttpClientModule, HTTP_INTERCEPTORS, HttpClient } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { HeaderInterceptorService } from './services/header-interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PenadoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  
  providers: [
    { provide: LOCALE_ID, useValue: 'es-CL' },
    DatePipe,
    { provide: HTTP_INTERCEPTORS, useClass: HeaderInterceptorService, multi: true }
  ],
  bootstrap: [AppComponent]

})
export class AppModule { }