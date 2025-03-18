import React from 'react';
import styles from './StatisticsInfoComponent.module.css';

interface StatisticsInfoProps {
  averagePrice?: string;
  impressions?: string;
  totalCount?: string;
}

const StatisticsInfoComponent: React.FC<StatisticsInfoProps> = ({
  averagePrice = '100',
  impressions = '200',
  totalCount = '300'
}) => {
  return (
    <div className={styles.statisticsInfo}>
      <span className={styles.infoText}>средняя цена</span>
      <span className={styles.infoText}>число показов</span>
      <span className={styles.infoText}>общее количество</span>
    </div>
  );
};

export default StatisticsInfoComponent;

