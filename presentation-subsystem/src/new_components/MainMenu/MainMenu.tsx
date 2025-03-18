import React from 'react';
import styles from './MainMenu.module.css';
import SortComponent from './SortComponent';
import FilterComponent from './FilterComponent';
import StatisticButton from './StatisticButton';

const MainMenu: React.FC = () => {
    return (
        <div className={styles.mainMenu}>
            <SortComponent />
            <FilterComponent />
            <StatisticButton />
        </div>
    );
};

export default MainMenu;

