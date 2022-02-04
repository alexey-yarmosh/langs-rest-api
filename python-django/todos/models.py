import json

class TodoModel:
  def get_all():
    file = TodoModel.read_file()
    return file['todos']

  def get_by_id(id):
    file = TodoModel.read_file()
    return next(todo for todo in file['todos'] if todo['id'] == id)

  def read_file():
    f = open("todos/data.json", "r")
    return json.loads(f.read())
