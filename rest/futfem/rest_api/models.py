from django.db import models

# Create your models here.
class Usuario (models.Model):
    nombre = models.CharField(max_length=50)
    apellido = models.CharField(max_length=150)
    email = models.CharField(max_length=150,unique=True)
    contrasena = models.CharField(max_length=150)
    tokenSession = models.CharField(max_length=150,unique=True,null=True)

class Equipos (models.Model):
    nombreEquipo = models.CharField(max_length=150)
    photoEscudo = models.CharField(max_length=150)
    photoEstadio = models.CharField(max_length=150)
    estadio = models.CharField(max_length=150)
    anoFundacion = models.CharField(max_length=150)
    entrenador = models.CharField(max_length=150)

class Jugadoras (models.Model):
    nombreJugadora = models.CharField(max_length=150)
    photoJugadora = models.CharField(max_length=150)
    numeroJugadora = models.CharField(max_length=150)
    posicionJugadora = models.CharField(max_length=150)
    idEquipo = models.ForeignKey(Equipos,on_delete=models.CASCADE)


class Clasificacion (models.Model):
    nombreEquipo = models.CharField(max_length=150)
    points = models.CharField(max_length=150)
    partidosJugador = models.CharField(max_length=150)
    partidosGanados = models.CharField(max_length=150)
    partidosEmpatados = models.CharField(max_length=150)
    partidosPerdidos = models.CharField(max_length=150)
    golesFavor = models.CharField(max_length=150)
    golesContra = models.CharField(max_length=150)


class Calendario (models.Model):
    jornada = models.CharField(max_length=150)
    fecha = models.CharField(max_length=150)
    escudoCasa = models.CharField(max_length=150)
    escudoVisitante = models.CharField(max_length=150)
    equipoCasa = models.CharField(max_length=150)
    equipoVisitante = models.CharField(max_length=150)
    hora = models.CharField(max_length=150)
    resultadoCasa = models.CharField(max_length=150)
    resultadoVisitante = models.CharField(max_length=150)
    estadoPartido = models.CharField(max_length=150)