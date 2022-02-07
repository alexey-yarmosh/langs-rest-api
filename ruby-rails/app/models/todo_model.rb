class TodoModel
  def self.get_todos()
    data = self.read_file()
    return data["todos"] 
  end

  def self.get_todo_by_id(id)
    data = self.read_file()
    todo = data["todos"].find{ |todo| todo["id"] == Integer(id) }
  end

  def self.read_file()
    file = File.open("app/models/data.json").read
    data = JSON.parse(file)
    return data
  end
end
