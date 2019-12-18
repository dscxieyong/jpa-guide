package com.orange.jpa.initial.repository;

import com.orange.jpa.initial.domain.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {
}
