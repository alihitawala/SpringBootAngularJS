import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'IR';
  greeting = {};

  constructor(private http: HttpClient) {
    http.get('resource').subscribe(data => this.greeting = data);
  }

  queryFromServer(query: string, type: string){
    if (query === '') {
      // handle this
      return;
    }

    this.http.get('query/' + query + "/" + type).subscribe((res)=>{
      console.log(res);
      this.greeting = res;
    });
  }
}
