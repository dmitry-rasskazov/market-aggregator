import React, { useState } from 'react';
import ToggleButton from '@mui/material/ToggleButton';
import ToggleButtonGroup from '@mui/material/ToggleButtonGroup';
import styles from './PeriodToggleComponent.module.css';

type Period = 'all' | '1year' | '6months' | '1month' | '1week' | '1day';

interface PeriodToggleComponentProps {
  onPeriodChange?: (period: Period) => void;
  defaultPeriod?: Period;
}

const PeriodToggleComponent: React.FC<PeriodToggleComponentProps> = ({
  onPeriodChange = () => {},
  defaultPeriod = 'all'
}) => {
  const [selectedPeriod, setSelectedPeriod] = useState<Period>(defaultPeriod);

  const handlePeriodChange = (
    event: React.MouseEvent<HTMLElement>,
    newPeriod: Period | null
  ) => {
    if (newPeriod !== null) {
      setSelectedPeriod(newPeriod);
      onPeriodChange(newPeriod);
    }
  };

  return (
    <ToggleButtonGroup
      value={selectedPeriod}
      exclusive
      onChange={handlePeriodChange}
      className={styles.periodToggle}
    >
      <ToggleButton value="all" className={styles.periodButton}>
        всё
      </ToggleButton>
      <ToggleButton value="1year" className={styles.periodButton}>
        1 год
      </ToggleButton>
      <ToggleButton value="6months" className={styles.periodButton}>
        6 месяцев
      </ToggleButton>
      <ToggleButton value="1month" className={styles.periodButton}>
        1 месяц
      </ToggleButton>
      <ToggleButton value="1week" className={styles.periodButton}>
        1 неделя
      </ToggleButton>
      <ToggleButton value="1day" className={styles.periodButton}>
        1 день
      </ToggleButton>
    </ToggleButtonGroup>
  );
};

export default PeriodToggleComponent;

