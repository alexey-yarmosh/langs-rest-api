using Newtonsoft.Json;

namespace TodoApi.Repositories
{
    public class TodosRepository
    {
        public TodosRepository()
        {}

        public List<Todo> GetAll()
        {
            Data data = this.GetData();
            return data.todos;
        }

        public Todo Get(long id)
        {
            Data data = this.GetData();
            return data.todos.Find(todo => todo.Id == id);
        }

        private Data GetData()
        {
            StreamReader r = new StreamReader("Repositories/data.json");
            string json = r.ReadToEnd();
            Data data = JsonConvert.DeserializeObject<Data>(json);
            return data;
        }
    }
}
