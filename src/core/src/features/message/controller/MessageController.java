package features.message.controller;

import core.CustomFormatter;
import core.CustomMapper;
import core.Session;
import database.DbConnection;
import features.message.model.MessageInfo;
import features.message.model.MessageType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class MessageController {
    DbConnection dbConnection = Session.getSession().getDbConnection();

    public boolean saveUserMessage(MessageInfo message,MessageType messageType){
        String template = "insert into bms_messages(title,message,messageType,userId) values ('{title}','{message}','{messageType}',{userId})";
        String userId = String.valueOf(Session.getSession().getLoggedInUser().getUserId());
        Map<String,String> values = Map.of("title",message.getTitle(),"message",message.getMessage(),"messageType",messageType.name(),"userId",userId);
        String query = CustomFormatter.format(template, values);
        int result = dbConnection.executeOnly(query);
        return result>0;
    }

    public boolean deleteUserMessage(){
        String template = "delete from bms_messages where userId = {userId}";
        String userId = String.valueOf(Session.getSession().getLoggedInUser().getUserId());
        Map<String,String> values = Map.of("userId",userId);
        String query = CustomFormatter.format(template, values);
        int result = dbConnection.executeOnly(query);
        return result>0;
    }

    public MessageInfo getUserLastMessage(){
        ArrayList<MessageInfo> messageInfoList = new ArrayList<>();
        try {
        String template = "select * from bms_messages where userId = {userId} order by createdAt desc;";
        String userId = String.valueOf(Session.getSession().getLoggedInUser().getUserId());
        Map<String,String> values = Map.of("userId",userId);
        String query = CustomFormatter.format(template, values);
        ResultSet result = dbConnection.executeWithResult(query);
            while (result.next()) {
                MessageInfo messageInfo = CustomMapper.mapResultSetToObject(result, MessageInfo.class);
                messageInfoList.add(messageInfo);
            }
            if(!messageInfoList.isEmpty()){
            return messageInfoList.getFirst();
            }
            return null;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
