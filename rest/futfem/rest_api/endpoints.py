from random import random

import bcrypt
from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt
import json

from rest_api.models import Equipos, Jugadoras, Clasificacion, Usuario


@csrf_exempt
def register(request):
    if request.method != 'POST':
        return JsonResponse({'error': 'HTTP method not supported'}, status=405)
    body_json = json.loads(request.body)
    try:
        json_name = body_json['nombre']
        json_apellido = body_json['apellido']
        json_email = body_json['email']
        json_password = body_json['contrasena']
    except KeyError:
        return JsonResponse({"error": "Missing parameter in JSON"}, status=400)
    if json_email.find('@') == -1 or len(json_email) < 8:
        return JsonResponse({"error": "Not valid email"}, status=400)
    try:
        checkEmail = Usuario.objects.get(email=json_email)
        if checkEmail != 0:
            return JsonResponse({"error": "Email already registered"}, status=409)
    except Usuario.DoesNotExist:
        salted_and_hashed_pass = bcrypt.hashpw(json_password.encode('utf8'), bcrypt.gensalt()).decode('utf8')
        # TODO Volver a encriptar la contrasena
        # user_object = Usuario(correo=json_email, alias=json_alias, nombre=json_name,contrasena=salted_and_hashed_pass)
        user_object = Usuario(email=json_email, apellido=json_apellido, nombre=json_name, contrasena=json_password)
        user_object.save()
        return JsonResponse({"is_created": True}, status=201)


@csrf_exempt
def login(request):
    if request.method == "POST":
        credentials_json = json.loads(request.body.decode("utf-8"))
        email = credentials_json.get("email")
        contrasena = credentials_json.get("contrasena")

        if not email or not contrasena:
            return JsonResponse({"Error": "Campos 'email' y 'contrasena' requeridos."}, status=400)

        try:
            usuario = Usuario.objects.get(email=email)

            if contrasena != usuario.contrasena:
                return JsonResponse({"Error": "Se ha producido un error. {usuario.contrasena.encode('utf8')} - {hashed}"}, status=401)

            tokenSession = random.randint(0, 9999999)
            usuario.tokenSession = tokenSession
            usuario.save()
            return JsonResponse({"tokenSession": tokenSession}, status=201)
        except Exception:
            return JsonResponse({"Error": "Se ha producido un error."}, status=401)

    return JsonResponse({"Error":"Error de protocolo no aceptado."},status=405)



def equipos(request):
  if request.method != 'GET':
    return JsonResponse({"error": "HTTP method not allowed"}, status=405)
  response = []
  for equipos in Equipos.objects.all():
    response.append({ "nombreEquipo": equipos.nombreEquipo,
                      "photoEscudo": equipos.photoEscudo,
                      "id": equipos.id,
                      })
  return JsonResponse(response, safe=False, status=200)



def detalle(request,equipo_id):
    if request.method != 'GET':
        return JsonResponse({"error": "Método no aceptado."}, status=405)
    try:
        equipo = Equipos.objects.get(id=equipo_id)
        response = [{
            "nombreEquipo": equipo.nombreEquipo,
            "photoEscudo": equipo.photoEscudo,
            "photoEstadio": equipo.photoEstadio,
            "estadio": equipo.estadio,
            "anoFundacion": equipo.anoFundacion,
            "entrenador": equipo.entrenador,
            "id": equipo.id,
        }]
        return JsonResponse(response, safe=False, status=200)
    except Equipos.DoesNotExist:
        return JsonResponse({'error': 'Equipo no encontrado'}, status=404)




def list_jugadoras(request,equipo_id):
    if request.method != 'GET':
        return JsonResponse({"error": "HTTP method not allowed"}, status=405)
    try:
        type = Equipos.objects.get(pk=equipo_id)
    except Equipos.DoesNotExist:
        return JsonResponse({"error": "El sitio de interes con el id " + str(equipo_id) + " no existe"}, status=404)
    jugadoras = Jugadoras.objects.filter(idEquipo=type)
    response = []
    for jugadora in jugadoras:
        response.append({"nombreJugadora": jugadora.nombreJugadora,
                         "photoJugadora": jugadora.photoJugadora,
                         "numeroJugadora": jugadora.numeroJugadora,
                         "posicionJugadora": jugadora.posicionJugadora,
                         "id": jugadora.id,
                         })
    return JsonResponse(response, safe=False, status=200)


def clasificacion(request):
    if request.method != 'GET':
        return JsonResponse({"error": "Método no aceptado."}, status=405)
    response = []
    for clasificacion in Clasificacion.objects.all():
        response.append({
            "nombreEquipo": clasificacion.nombreEquipo,
            "points": clasificacion.points,
            "partidosJugador": clasificacion.partidosJugador,
            "partidosGanados": clasificacion.partidosGanados,
            "partidosEmpatados": clasificacion.partidosEmpatados,
            "partidosPerdidos": clasificacion.partidosPerdidos,
            "golesFavor": clasificacion.golesFavor,
            "golesContra": clasificacion.golesContra,
            "id": clasificacion.id,
        })
    return JsonResponse(response, safe=False, status=200)




