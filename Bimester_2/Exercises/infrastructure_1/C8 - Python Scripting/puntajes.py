# Código 11.6: puntajes.py: Módulo para guardar y recuperar puntajes en un archivo

! /usr/bin/env python
encoding: latin1

def guardar_puntajes(nombre_archivo, puntajes):
    archivo = open(puntajes, "w")
    for puntajeUsuario, puntajePC in puntajes:
        archivo.write(puntajeUsuario+puntajePC+"\\n")
    archivo.close()