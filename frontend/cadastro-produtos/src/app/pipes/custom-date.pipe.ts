import { Pipe, PipeTransform } from '@angular/core';
import { DatePipe } from '@angular/common';

@Pipe({
  name: 'customDate',
  standalone: true
})
export class CustomDatePipe implements PipeTransform {
  transform(value: any, format: string = 'dd/MM/yyyy HH:mm'): string {
    if (!value) return 'N/A';
    
    // Se já for um objeto Date
    if (value instanceof Date) {
      const datePipe = new DatePipe('pt-BR');
      return datePipe.transform(value, format) || 'N/A';
    }
    
    // Se for uma string, tenta converter para Date
    if (typeof value === 'string') {
      // Se for no formato brasileiro, converte manualmente
      if (/^\d{2}\/\d{2}\/\d{4}/.test(value)) {
        const parts = value.split(/[\/\s:]/);
        if (parts.length >= 3) {
          const day = parseInt(parts[0], 10);
          const month = parseInt(parts[1], 10) - 1; // Mês em JS começa em 0
          const year = parseInt(parts[2], 10);
          const hours = parts.length > 3 ? parseInt(parts[3], 10) : 0;
          const minutes = parts.length > 4 ? parseInt(parts[4], 10) : 0;
          const seconds = parts.length > 5 ? parseInt(parts[5], 10) : 0;
          
          const date = new Date(year, month, day, hours, minutes, seconds);
          if (!isNaN(date.getTime())) {
            const datePipe = new DatePipe('pt-BR');
            return datePipe.transform(date, format) || 'N/A';
          }
        }
      }
      
      // Tenta converter de formato ISO
      const date = new Date(value);
      if (!isNaN(date.getTime())) {
        const datePipe = new DatePipe('pt-BR');
        return datePipe.transform(date, format) || 'N/A';
      }
      
      // Se não conseguiu converter, retorna a string original
      return value;
    }
    
    return 'N/A';
  }
}