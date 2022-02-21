using TodoApi.Repositories;

namespace TodoApi.Services
{
    public class TodosService
    {
        private readonly TodosRepository _todosRepository;

        public TodosService(TodosRepository todosRepository)
        {
            _todosRepository = todosRepository;
        }

        public List<Todo> GetAll() =>
            _todosRepository.GetAll();

        public Todo Get(long id) =>
            _todosRepository.Get(id);
    }
}
