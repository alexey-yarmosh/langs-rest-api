class TodosService
  def self.get_todos()
    return TodoModel.get_todos()
  end

  def self.get_todo_by_id(id)
    return TodoModel.get_todo_by_id(id)
  end
end
