import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { EventService } from '../../services/event-service/event.service';

@Component({
  selector: 'app-events',
  imports: [MatCardModule, MatTableModule],
  templateUrl: './events.component.html',
  styleUrl: './events.component.css'
})

export class EventsComponent {
  events: any[] = [];

  constructor(private eventService: EventService) {}

  ngOnInit() {
    this.loadEvents();
  }

  loadEvents() {
    this.eventService.getAllEvents().subscribe((data: any[]) => {
      this.events = data;
    });
  }

  createEvent(newEvent: any) {
    this.eventService.createEvent(newEvent).subscribe(() => this.loadEvents());
  }

  deleteEvent(id: number) {
    this.eventService.deleteEvent(id).subscribe(() => this.loadEvents());
  }
}
