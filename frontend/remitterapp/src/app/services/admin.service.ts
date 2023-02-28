import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private httpClient: HttpClient) { }

  public getAdminByEmailAndPassword(email: any, password: any) {
    return this.httpClient.get("http://localhost:9191/admin/get/"+email+"/"+password);
  }
}
