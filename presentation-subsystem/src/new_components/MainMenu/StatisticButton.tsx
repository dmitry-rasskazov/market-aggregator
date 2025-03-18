import React from 'react';
import Button from '@mui/material/Button';
import styles from './StatisticButton.module.css';

const StatisticButton: React.FC = () => {
    return (
        <Button className={styles.statisticButton} variant="text">
            <span className={styles.text}>статистика</span>
            <img 
                src="https://dashboard.codeparrot.ai/api/image/Z9k3pJIdzXb5Olay/chevron-r.png" 
                alt="chevron" 
                className={styles.chevron}
            />
        </Button>
    );
};

export default StatisticButton;

