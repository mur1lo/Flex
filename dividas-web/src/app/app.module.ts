import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';


import { PrimeNgModule } from './prime-ng/primeng.module';
import { UsuarioComponent } from './content/usuario/usuario.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { CurrencyMaskModule } from "ng2-currency-mask";
import { AppRoutingModule } from './app-routing.module';
import { CadastroComponent } from './content/usuario/cadastro/cadastro.component';

@NgModule({
  declarations: [
    AppComponent,
    UsuarioComponent,
    CadastroComponent
  ],
  imports: [
    BrowserModule,
    PrimeNgModule,
    HttpClientModule,
    FormsModule,
    AngularFontAwesomeModule,
    CurrencyMaskModule,
    AppRoutingModule
  ],
  providers: [
    { provide: LOCALE_ID, useValue: 'pt' }
  ],
  bootstrap: [AppComponent],
  exports: [UsuarioComponent, CadastroComponent],
  entryComponents: [UsuarioComponent]
})
export class AppModule { }
