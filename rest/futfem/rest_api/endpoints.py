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