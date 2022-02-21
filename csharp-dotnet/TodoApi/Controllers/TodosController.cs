using Microsoft.AspNetCore.Mvc;
using TodoApi.Services;

namespace TodoApi.Controllers;
[ApiController]
[Route("[controller]")]
public class TodosController : ControllerBase
{
    private readonly TodosService _todosService;

    public TodosController(TodosService todosService)
    {
        _todosService = todosService;
    }

    [HttpGet]
    public IEnumerable<Todo> GetAll() =>
        _todosService.GetAll();

    [HttpGet("{id}")]
    public Todo Get(long id) =>
        _todosService.Get(id);
}
