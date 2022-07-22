import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'vehicleFilter'
})
export class VehicleFilterPipe implements PipeTransform {

  transform(value: any, vehicleName: string): any {
    if(!vehicleName) return value
    else {
      return value.filter((loc: { vehicleName: string; }) => loc.vehicleName.toLowerCase().indexOf(vehicleName.toLowerCase())!= -1);
    }
  }

}
