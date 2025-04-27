import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './componentes/header/header.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  hostDirectives: [{ directive: NgSkipHydration }]  // Add this line
})
export class AppComponent {
  title = 'cadastro-produtos';
}
