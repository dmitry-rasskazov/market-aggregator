import React from 'react';
import styles from './StatisticsLayout.module.css';
import GraphComponent from './GraphComponent';
import PeriodToggleComponent from './PeriodToggleComponent';
import StatisticsInfoComponent from './StatisticsInfoComponent';

const StatisticsLayout: React.FC = () => {
  return (
    <div className={styles.statisticsContainer}>
      <div className={styles.periodToggleTop}>
        <PeriodToggleComponent />
      </div>
      <div className={styles.graphContainer}>
        <GraphComponent />
      </div>
      <div className={styles.statisticsInfoBottom}>
        <StatisticsInfoComponent />
      </div>
    </div>
  );
};

export default StatisticsLayout;

