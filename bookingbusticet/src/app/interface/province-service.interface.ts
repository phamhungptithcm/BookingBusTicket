import { Observable, of} from 'rxjs';
import { Province } from '../models/province';

export interface ProvinceSevice {
     findAll(): Observable<Province[]>;
     findById(id: number): Observable<Province>;
     delete(id: number): Observable<Province>;
     save(province: Province): Observable<Province>;
     update(province: Province): Observable<any>;
     searchProvinceFrom(typedString: String): Observable<Province[]>;
     searchProvinceTo(typedString: String,id: number): Observable<Province[]>;
}