from django.http import JsonResponse

def health(request):
    return JsonResponse({"status":"alive"}, status=200)