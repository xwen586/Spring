package sia2.Knight2;

/* 通过interface来隐藏实现细节 */
public interface Quest {
    public Object embark() throws QuestFailedException;
}
