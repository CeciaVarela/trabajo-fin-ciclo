from django.http import JsonResponse

from rest_api.models import Equipos, Jugadoras


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