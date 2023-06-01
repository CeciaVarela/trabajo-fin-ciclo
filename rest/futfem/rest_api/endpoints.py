from django.http import JsonResponse

from rest_api.models import Equipos


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

