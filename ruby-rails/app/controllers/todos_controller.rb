class TodosController < ApplicationController
  def get_todos
    todos = TodosService.get_todos()
    render json: todos
  end

  def get_todo_by_id
    todo = TodosService.get_todo_by_id(params[:id])
    render json: todo
  end
end
