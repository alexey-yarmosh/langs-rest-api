Rails.application.routes.draw do
  # Define your application routes per the DSL in https://guides.rubyonrails.org/routing.html

  # Defines the root path route ("/")
  # root "articles#index"
  root "todos#index"

  get "/todos", to: "todos#get_todos"
  get "/todos/:id", to: "todos#get_todo_by_id"
end
