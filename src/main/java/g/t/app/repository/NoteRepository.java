package g.t.app.repository;

import g.t.app.domain.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {

    @EntityGraph(attributePaths = "attachedFiles")
    Optional<Note> findById(Long id);

    @EntityGraph(attributePaths = "attachedFiles")
    Page<Note> findAll(Pageable pageable);

    @Query("select n.createdByUser.id from Note n where n.id=:id ")
    Long findCreatedByUserIdById(@Param("id") Long id);
}
