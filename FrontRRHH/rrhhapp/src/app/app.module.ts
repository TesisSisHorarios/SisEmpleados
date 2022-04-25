 import { HttpClientModule } from '@angular/common/http';
import { NgModule,Compiler, COMPILER_OPTIONS, CompilerFactory } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmpleadoComponent } from './components/empleado/empleado.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {JitCompilerFactory} from '@angular/platform-browser-dynamic';

import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';
import {TabMenuModule} from 'primeng/tabmenu';
import {MenuModule} from 'primeng/menu';
import {ToolbarModule} from 'primeng/toolbar';
import {DialogModule} from 'primeng/dialog';
import {InputTextModule} from 'primeng/inputtext';
import {FormsModule} from '@angular/forms';
import {InputMaskModule} from 'primeng/inputmask';
import {DropdownModule} from 'primeng/dropdown';
import {CalendarModule} from 'primeng/calendar';
import {MessageService} from 'primeng/api';
import {SharedModule} from "./shared/shared.module";
import {ToastModule} from 'primeng/toast';
import {ConfirmationService} from 'primeng/api';
import { ConfirmPopupModule } from "primeng/confirmpopup";
import { ConfirmDialogModule } from 'primeng/confirmdialog';
export function createCompiler(compilerFactory: CompilerFactory) {
  return compilerFactory.createCompiler();
}


@NgModule({
  declarations: [
    AppComponent,
    EmpleadoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ButtonModule,
    TableModule,
    TabMenuModule,
    MenuModule,
    ToolbarModule,
    DialogModule,
    InputTextModule,
    FormsModule,
    InputMaskModule,
    DropdownModule,
    CalendarModule,
    HttpClientModule,
    SharedModule,
    ToastModule,
    ConfirmDialogModule
  ],
  providers: [MessageService, ConfirmationService,
    {provide: COMPILER_OPTIONS, useValue: {}, multi: true},
    {provide: CompilerFactory, useClass: JitCompilerFactory, deps: [COMPILER_OPTIONS]},
    {provide: Compiler, useFactory: createCompiler, deps: [CompilerFactory]}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
