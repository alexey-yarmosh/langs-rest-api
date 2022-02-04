from curses.ascii import HT
import json
from django.http import HttpResponse
from .services import TodoService

def all_todos(request):
    data = TodoService.get_all()
    return HttpResponse(json.dumps(data))

def todo(request, id):
    data = TodoService.get_by_id(id)
    return HttpResponse(json.dumps(data))
