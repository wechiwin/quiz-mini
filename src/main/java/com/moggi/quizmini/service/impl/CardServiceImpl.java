package com.moggi.quizmini.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moggi.quizmini.entity.Card;
import com.moggi.quizmini.mapper.CardMapper;
import com.moggi.quizmini.service.CardService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wechiwin
 * @since 2024-02-07
 */
@Service
public class CardServiceImpl extends ServiceImpl<CardMapper, Card> implements CardService {

}
