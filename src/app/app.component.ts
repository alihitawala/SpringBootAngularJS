import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PagerService } from './services';
import 'rxjs/add/operator/map'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'IR';
  greeting = {};
  private results: any[];
  // pager object
  pager: any = {};
  // paged items
  pagedItems: any[];

  constructor(private http: HttpClient, private pagerService: PagerService) {
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
      this.results = res['results'];
      this.setPage(1);
    });
  }

  setPage(page: number) {
    // get pager object from service
    this.pager = this.pagerService.getPager(this.results.length, page);
    // get current page of items
    this.pagedItems = this.results.slice(this.pager.startIndex, this.pager.endIndex + 1);
  }
}
