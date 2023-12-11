package com.example.testing.repo;

import com.example.testing.entity.Child;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {ChildRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.example.testing.entity"})
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 自動生成時はこの行が無いのでDBアクセスに失敗して動かない。デフォルトの挙動をこれにする方法があればそのまま動くと思うのだが…
class ChildRepositoryDiffblueTest {
    @Autowired
    private ChildRepository childRepository;

    /**
     * Method under test: {@link ChildRepository#findByDummyId(Long)}
     */
    @Test
//    @Disabled("TODO: Complete this test")
    void testFindByDummyId() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.InvalidDataAccessResourceUsageException: could not prepare statement [user lacks privilege or object not found: CHILD in statement [insert into child (dummy_id,name,text) values (?,?,?)]] [insert into child (dummy_id,name,text) values (?,?,?)]; SQL [insert into child (dummy_id,name,text) values (?,?,?)]
        //       at jdk.proxy4/jdk.proxy4.$Proxy162.save(Unknown Source)
        //   org.hibernate.exception.SQLGrammarException: could not prepare statement [user lacks privilege or object not found: CHILD in statement [insert into child (dummy_id,name,text) values (?,?,?)]] [insert into child (dummy_id,name,text) values (?,?,?)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:66)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:58)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl$StatementPreparationTemplate.prepareStatement(MutationStatementPreparerImpl.java:110)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl.prepareStatement(MutationStatementPreparerImpl.java:60)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.prepareStatement(GetGeneratedKeysDelegate.java:86)
        //       at org.hibernate.engine.jdbc.mutation.internal.ModelMutationHelper.lambda$identityPreparation$1(ModelMutationHelper.java:132)
        //       at org.hibernate.engine.jdbc.mutation.internal.PreparedStatementDetailsStandard.resolveStatement(PreparedStatementDetailsStandard.java:87)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:103)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:171)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:112)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2860)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:667)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:290)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:271)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:321)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:766)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:750)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy162.save(Unknown Source)
        //   java.sql.SQLSyntaxErrorException: user lacks privilege or object not found: CHILD in statement [insert into child (dummy_id,name,text) values (?,?,?)]
        //       at org.hsqldb.jdbc.JDBCUtil.sqlException(Unknown Source)
        //       at org.hsqldb.jdbc.JDBCUtil.sqlException(Unknown Source)
        //       at org.hsqldb.jdbc.JDBCPreparedStatement.<init>(Unknown Source)
        //       at org.hsqldb.jdbc.JDBCConnection.prepareStatement(Unknown Source)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl$2.doPrepare(MutationStatementPreparerImpl.java:58)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl$StatementPreparationTemplate.prepareStatement(MutationStatementPreparerImpl.java:100)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl.prepareStatement(MutationStatementPreparerImpl.java:60)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.prepareStatement(GetGeneratedKeysDelegate.java:86)
        //       at org.hibernate.engine.jdbc.mutation.internal.ModelMutationHelper.lambda$identityPreparation$1(ModelMutationHelper.java:132)
        //       at org.hibernate.engine.jdbc.mutation.internal.PreparedStatementDetailsStandard.resolveStatement(PreparedStatementDetailsStandard.java:87)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:103)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:171)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:112)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2860)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:667)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:290)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:271)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:321)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:766)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:750)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy162.save(Unknown Source)
        //   org.hsqldb.HsqlException: user lacks privilege or object not found: CHILD
        //       at org.hsqldb.error.Error.error(Unknown Source)
        //       at org.hsqldb.error.Error.error(Unknown Source)
        //       at org.hsqldb.ParserDQL.readTableName(Unknown Source)
        //       at org.hsqldb.ParserDQL.readRangeVariableForDataChange(Unknown Source)
        //       at org.hsqldb.ParserDML.compileInsertStatement(Unknown Source)
        //       at org.hsqldb.ParserCommand.compilePart(Unknown Source)
        //       at org.hsqldb.ParserCommand.compileStatement(Unknown Source)
        //       at org.hsqldb.Session.compileStatement(Unknown Source)
        //       at org.hsqldb.StatementManager.compile(Unknown Source)
        //       at org.hsqldb.Session.execute(Unknown Source)
        //       at org.hsqldb.jdbc.JDBCPreparedStatement.<init>(Unknown Source)
        //       at org.hsqldb.jdbc.JDBCConnection.prepareStatement(Unknown Source)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl$2.doPrepare(MutationStatementPreparerImpl.java:58)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl$StatementPreparationTemplate.prepareStatement(MutationStatementPreparerImpl.java:100)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl.prepareStatement(MutationStatementPreparerImpl.java:60)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.prepareStatement(GetGeneratedKeysDelegate.java:86)
        //       at org.hibernate.engine.jdbc.mutation.internal.ModelMutationHelper.lambda$identityPreparation$1(ModelMutationHelper.java:132)
        //       at org.hibernate.engine.jdbc.mutation.internal.PreparedStatementDetailsStandard.resolveStatement(PreparedStatementDetailsStandard.java:87)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:103)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:171)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:112)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2860)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:667)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:290)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:271)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:321)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:386)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:300)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:219)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:134)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:766)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:750)
        //       at jdk.proxy4/jdk.proxy4.$Proxy156.persist(Unknown Source)
        //       at jdk.proxy4/jdk.proxy4.$Proxy162.save(Unknown Source)
        //   See https://diff.blue/R013 to resolve this issue.

        Child child = new Child();
        child.setDummyId(1L);
        child.setName("Name");
        child.setText("Text");

        Child child2 = new Child();
        child2.setDummyId(2L);
        child2.setName("com.example.testing.entity.Child");
        child2.setText("com.example.testing.entity.Child");
        childRepository.save(child);
        childRepository.save(child2);
        childRepository.findByDummyId(1L);
    }
}
