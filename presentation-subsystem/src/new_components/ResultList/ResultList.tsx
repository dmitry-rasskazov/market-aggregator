import React from 'react';
import styles from './ResultList.module.css';
import ResultItem from './ResultItem';
import Pagination from './Pagination';

const ResultList: React.FC = () => {
    return (
        <div className={styles.resultList}>
            <ResultItem 
                title="Набор инструментов для ремонта"
                description="Краткое описание, как правило, первая часть основного описания, ограничено доступной длиной части кратного описания результата поиска..."
                price="222,23 ₽/шт"
                image="https://dashboard.codeparrot.ai/api/image/Z9k665IdzXb5Olaz/short-ima.png"
                rating={3.5}
                vendorRating={4.5}
                vendorName="Short vendor's name..."
            />
            <ResultItem 
                title="Набор инструментов для ремонта"
                description="Краткое описание, как правило, первая часть основного описания, ограничено доступной длиной части кратного описания результата поиска..."
                price="222,23 ₽/шт"
                image="https://dashboard.codeparrot.ai/api/image/Z9k665IdzXb5Olaz/short-ima.png"
                rating={3.5}
                vendorRating={4.5}
                vendorName="Short vendor's name..."
            />
            <ResultItem 
                title="Набор инструментов для ремонта"
                description="Краткое описание, как правило, первая часть основного описания, ограничено доступной длиной части кратного описания результата поиска..."
                price="222,23 ₽/шт"
                image="https://dashboard.codeparrot.ai/api/image/Z9k665IdzXb5Olaz/short-ima.png"
                rating={3.5}
                vendorRating={4.5}
                vendorName="Short vendor's name..."
            />
            <ResultItem 
                title="Набор инструментов для ремонта"
                description="Краткое описание, как правило, первая часть основного описания, ограничено доступной длиной части кратного описания результата поиска..."
                price="222,23 ₽/шт"
                image="https://dashboard.codeparrot.ai/api/image/Z9k665IdzXb5Olaz/short-ima.png"
                rating={3.5}
                vendorRating={4.5}
                vendorName="Short vendor's name..."
            />
            <Pagination currentPage={1} totalPages={99} onPageChange={(page) => console.log(`Page changed to ${page}`)} />
        </div>
    );
};

export default ResultList;

