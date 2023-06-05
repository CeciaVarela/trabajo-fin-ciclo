from django.http import JsonResponse

from rest_api.models import Equipos, Jugadoras, Clasificacion


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