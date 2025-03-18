import React from 'react';
import styles from './Pagination.module.css';

interface PaginationProps {
    currentPage?: number;
    totalPages?: number;
    onPageChange?: (page: number) => void;
}

const Pagination: React.FC<PaginationProps> = ({
    currentPage = 1,
    totalPages = 99,
    onPageChange = () => {},
}) => {
    const handlePageClick = (page: number) => {
        if (page >= 1 && page <= totalPages) {
            onPageChange(page);
        }
    };

    return (
        <div className={styles.pagination}>
            <div className={styles.numbers}>
                <button 
                    className={`${styles.pageNumber} ${currentPage === 1 ? styles.active : ''}`}
                    onClick={() => handlePageClick(1)}
                >
                    1
                </button>
                <button 
                    className={`${styles.pageNumber} ${currentPage === 2 ? styles.active : ''}`}
                    onClick={() => handlePageClick(2)}
                >
                    2
                </button>
                <button 
                    className={`${styles.pageNumber} ${currentPage === 3 ? styles.active : ''}`}
                    onClick={() => handlePageClick(3)}
                >
                    3
                </button>
                <span className={styles.ellipsis}>...</span>
                <button 
                    className={`${styles.pageNumber} ${currentPage === totalPages ? styles.active : ''}`}
                    onClick={() => handlePageClick(totalPages)}
                >
                    {totalPages}
                </button>
            </div>
        </div>
    );
};

export default Pagination;

