package com.example.gigacf.v2.common.commonLogics;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.log4j.Log4j2;

/* abstractDAO
 * 1. 자식DAO에 공통적으로 들어갈 sqlSession의 로직을 설정해준다.
 * 2. 그리고 파라미터에 들어오는 값을 확인한 log로 설정한다. 
 * */
@Log4j2
public class AbstractDAO<T> {
     
    @Autowired
    private SqlSessionTemplate sqlSession;
      
    // mapper에 보낸 augument가 들어왔는지 아래 메소드에들 log 찍어주는 메소드
    protected void printQueryId(String queryId) {
        if(log.isDebugEnabled()){
            log.debug("\t QueryId  \t:  " + queryId);
        }
    }
      
    // queryId는 Dao파라미터와 mapper.xml의 퀴리의 id에 입력하여 이 둘을 mapping하는 역할을 한다.
    public <E> int insert(String queryId, E params){
        printQueryId(queryId);
        return sqlSession.insert(queryId, params);
    }
      
    public <E> int update(String queryId, E params){
        printQueryId(queryId);
        return sqlSession.update(queryId, params);
    }
    
    public <E> int updateList(String queryId, E params) {
    	printQueryId(queryId);
    	return sqlSession.update(queryId, params);
    }
      
    public <E> int delete(String queryId, E params){
        printQueryId(queryId);
        return sqlSession.delete(queryId, params);
    }
      
    public <E> E selectOne(String queryId){
        printQueryId(queryId);
        return sqlSession.selectOne(queryId);
    }
      
    public <E> E selectOne(String queryId, Object params){
        printQueryId(queryId);
        return sqlSession.selectOne(queryId, params);
    }
      
    public List<T> selectList(String queryId) {
        printQueryId(queryId);
        return sqlSession.selectList(queryId);
    }

    public <E> List<T> selectList(String queryId, E params) {
        printQueryId(queryId);
        return sqlSession.selectList(queryId, params);
    }









 
    
    
}
