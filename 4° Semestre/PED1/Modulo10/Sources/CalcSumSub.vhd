library IEEE;
use IEEE.STD_LOGIC_1164.ALL;


entity CalcSumSub is
    Port ( a : in STD_LOGIC_VECTOR (3 downto 0);
           b : in STD_LOGIC_VECTOR (3 downto 0);
           op : in STD_LOGIC;
           ovf : out STD_LOGIC;
           clk : in STD_LOGIC;
           an : out STD_LOGIC_VECTOR (3 downto 0);
           seg : out STD_LOGIC_VECTOR (6 downto 0);
           dp : out STD_LOGIC
           );
end CalcSumSub;

architecture Behavioral of CalcSumSub is


    signal s_s : STD_LOGIC_VECTOR (3 downto 0);
    
    component sumSub 
        Port ( busx : in STD_LOGIC_VECTOR (3 downto 0);
               busy : in STD_LOGIC_VECTOR (3 downto 0);
               op : in STD_LOGIC;
               busS : out STD_LOGIC_VECTOR (3 downto 0);
               overflow : out STD_LOGIC);
    end component;

    component MainMux
        Port ( a : in STD_LOGIC_VECTOR (3 downto 0);
               b : in STD_LOGIC_VECTOR (3 downto 0);
               c : in STD_LOGIC_VECTOR (3 downto 0);
               clk : in STD_LOGIC;
               an : out STD_LOGIC_VECTOR (3 downto 0);
               seg : out STD_LOGIC_VECTOR (6 downto 0);
               dp : out STD_LOGIC);
    end component;
    
begin

    calc : sumSub port map(busx => a, busy => b, op => op, busS => s_s, overflow => ovf);
    disp : MainMux port map(a => a, b => b, c => s_s, clk => clk, an => an, seg => seg, dp => dp);

end Behavioral;
