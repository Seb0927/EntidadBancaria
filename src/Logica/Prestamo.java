/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author invitado
 */
public class Prestamo {
    
    float monto;
    int cantidadMeses;
    float tasa;
    float cuota;
    float[][] tablaAmortizacion;
    
    public Prestamo(float monto, int cantidadMeses) {
        this.monto = monto;
        this.cantidadMeses = cantidadMeses;
        tablaAmortizacion = new float[cantidadMeses][5];
        calcularTasa();
        calcularCuota();
    }
    
    public float getMonto() {
        return monto;
    }
    
    public void setMonto(float monto) {
        this.monto = monto;
    }
    
    public int getCantidadMeses() {
        return cantidadMeses;
    }
    
    public void setCantidadMeses(int cantidadMeses) {
        this.cantidadMeses = cantidadMeses;
    }
    
    public float getTasa() {
        return tasa;
    }
    
    public float[][] getTablaAmortizacion() {
        return tablaAmortizacion;
    }
    
    public void setTablaAmortizacion(float[][] tablaAmortizacion) {
        this.tablaAmortizacion = tablaAmortizacion;
    }
    
    public void calcularTasa() {
        if (monto < 1500000 && cantidadMeses < 12) {
            tasa = (float) (2.5 / 100);
        } else if (monto < 1500000 && cantidadMeses >= 12) {
            tasa = (float) (1.8 / 100);
        } else if ((monto >= 1500000 && monto <= 300000) && cantidadMeses < 12) {
            tasa = (float) (1.9 / 100);
        } else if ((monto >= 1500000 && monto <= 300000) && cantidadMeses >= 12) {
            tasa = (float) (1.7 / 100);
        } else {
            tasa = (float) (1.5 / 100);
        }
    }
    
    public void calcularCuota() {
        cuota = (float) (monto * ((Math.pow(1 + tasa, cantidadMeses) * tasa) / (Math.pow(1 + tasa, cantidadMeses) - 1)));
        cuota = redondearNumero(cuota);
    }
    
    public void calcularSaldo(int fila) {
        if (fila == 0) {
            tablaAmortizacion[fila][0] = monto;
        } else {
            tablaAmortizacion[fila][0] = tablaAmortizacion[fila - 1][4];
            tablaAmortizacion[fila][0] = redondearNumero( tablaAmortizacion[fila][0]);
        }
    }
    
    public void calcularInteres(int fila) {
        tablaAmortizacion[fila][1] = tablaAmortizacion[fila][0] * tasa;
        tablaAmortizacion[fila][1] = redondearNumero( tablaAmortizacion[fila][1]);
    }
    
    public void calcularCuota(int fila) {
        tablaAmortizacion[fila][2] = cuota;
        tablaAmortizacion[fila][2] = redondearNumero( tablaAmortizacion[fila][2]);
    }
    
    private void calcularAbono(int fila) {
        tablaAmortizacion[fila][3] = tablaAmortizacion[fila][2] - tablaAmortizacion[fila][1];
        tablaAmortizacion[fila][3] = redondearNumero( tablaAmortizacion[fila][3]);
    }
    
    private void calcularSaldoFinal(int fila) {
        tablaAmortizacion[fila][4] = tablaAmortizacion[fila][0] - tablaAmortizacion[fila][3];
        tablaAmortizacion[fila][4] = redondearNumero( tablaAmortizacion[fila][4]);
        if(fila==cantidadMeses-1){
            tablaAmortizacion[fila][4] = 0;
        }
    }
    
    public void realizarTabla() {
        for (int fila = 0; fila < cantidadMeses; fila++) {
            calcularSaldo(fila);
            calcularInteres(fila);
            calcularCuota(fila);
            calcularAbono(fila);
            calcularSaldoFinal(fila);
        }
    }
    
    public void imprimirTabla() {
        for (int fila = 0; fila < cantidadMeses; fila++) {
            System.out.println((fila + 1) + "\t" + tablaAmortizacion[fila][0] + "\t" + tablaAmortizacion[fila][1] + "\t" + tablaAmortizacion[fila][2] + "\t" + tablaAmortizacion[fila][3] + "\t" + tablaAmortizacion[fila][4] + "\t");
        }
    }
    
    public float redondearNumero(float numero) {
        return Math.round(numero);
    }
}
