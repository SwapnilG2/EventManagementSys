import { DataSource } from '@angular/cdk/collections';
import { Component } from '@angular/core';
import { MatCard, MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-bookings',
  imports: [MatCardModule, MatTableModule],
  templateUrl: './bookings.component.html',
  styleUrl: './bookings.component.css'
})
export class BookingsComponent {
  bookings = [];
}
