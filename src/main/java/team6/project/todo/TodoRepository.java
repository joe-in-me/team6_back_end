package team6.project.todo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import team6.project.todo.model.PatchTodoDto;
import team6.project.todo.model.TodoDeleteDto;
import team6.project.todo.model.TodoSelectTransVo;
import team6.project.todo.model.proc.EmotionSelectTmpResult;
import team6.project.todo.model.proc.InsertTodoDto;
import team6.project.todo.model.proc.TodoSelectTmpResult;
import team6.project.todo.model.proc.RepeatInsertDto;
import team6.project.todo.model.ref.TodoSelectVoRef;

import java.time.LocalDate;
import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class TodoRepository implements TodoRepositoryRef {

    private final TodoMapper mapper;


    public Integer getListCountById(Integer iuser, LocalDate startDate) {
        return mapper.getTodoListCount(iuser, startDate);
    }

    public Integer saveTodo(InsertTodoDto dto) {
        return mapper.insTodo(dto);
    }

    public Integer saveRepeat(RepeatInsertDto dto) {
        return mapper.insRepeat(dto);
    }

    public List<TodoSelectTmpResult> findTodoAndRepeatBy(TodoSelectVoRef dto) {
        return mapper.selectTodo(dto);
    }

    public EmotionSelectTmpResult findEmotionAndEmotionTagBy(TodoSelectTransVo dto) {
        return mapper.selectEmotion(dto);
    }


    public Integer deleteRepeat(TodoDeleteDto dto) {
        return mapper.deleteTodoRepeat(dto);
    }

    public Integer deleteTodo(TodoDeleteDto dto) {
        return mapper.deleteTodo(dto);
    }

    public Integer updateTodoAndRepeatIfExists(PatchTodoDto dto) {

        // join 해서 update 라 2가 나올수도 있음.
        // 그에 관계없이 성공하면 항상 1, 실패하면 항상 1 을 리턴하기 위한부분 추가.
        return mapper.patchTodoAndRepeatIfExists(dto) == 0 ? 0 : 1;

    }


    public RepeatInsertDto findRepeatBy(Integer itodo) {
        return mapper.selectOnlyRepeat(itodo);
    }

}
