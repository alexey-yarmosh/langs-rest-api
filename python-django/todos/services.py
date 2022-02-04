from .models import TodoModel

class TodoService:
  def get_all():
    return TodoModel.get_all()

  def get_by_id(id):
    return TodoModel.get_by_id(id)
