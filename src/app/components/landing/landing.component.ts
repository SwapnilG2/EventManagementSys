import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule} from '@angular/material/card';
import { MatIconModule} from '@angular/material/icon';
import { MatToolbar } from '@angular/material/toolbar';
import { RouterModule } from '@angular/router';
@Component({
  selector: 'app-landing',
  imports: [CommonModule, MatButtonModule, MatCardModule, MatIconModule, MatToolbar, RouterModule],
  templateUrl: './landing.component.html',
  styleUrl: './landing.component.css',
  standalone : true
})

export class LandingComponent {
  features = [
    {
      icon: 'event_available',
      title: 'Easy Scheduling',
      description: 'Plan and schedule events with just a few clicks.'
    },
    {
      icon: 'group',
      title: 'Collaborate Easily',
      description: 'Invite and manage attendees seamlessly.'
    },
    {
      icon: 'insights',
      title: 'Real-Time Insights',
      description: 'Monitor progress with live reports and analytics.'
    },
    {
      icon: 'security',
      title: 'Secure Platform',
      description: 'Your data is safe with our top-tier security.'
    }
  ];
}

